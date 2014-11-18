using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for StockReader
/// </summary>
public class StockReader
{
    public static List<StockData> Read(string strPath)
    {
        List<StockData> lstStockData;
        try
        {
            System.Xml.XmlTextReader reader = new System.Xml.XmlTextReader(strPath);
            reader.Read();
            lstStockData = new List<StockData>();

            while (reader.Read())
            {
                reader.MoveToContent();
                if (reader.NodeType == System.Xml.XmlNodeType.Element)
                {
                    if (reader.Name == "Row")
                    {
                        StockData S = readClosingPrices(reader);
                        lstStockData.Add(S);
                    }
                }
            }
            return lstStockData;
        }
        catch (System.IO.FileNotFoundException)
        {
            return null;
        }
    }

    static string nextValue(System.Xml.XmlTextReader reader)
    {
        while (reader.Read())
        {
            if (reader.NodeType == System.Xml.XmlNodeType.Text)
                return reader.Value;
        }
        return null;
    }

    static StockData readClosingPrices(System.Xml.XmlTextReader reader)
    {
        // Excel dates are encoded as integers, where 1/1/1900 = 1. There is a bug
        // in their date calculations because they consider 1900 to be a leap year. This
        // bug was never corrected because it first appeared in Lotus 1-2-3 and Microsoft
        // wanted the two products to be compatible.

        int offset = 2;
        int excelDays = Convert.ToInt32(nextValue(reader)) - offset;
        DateTime start = new DateTime(1900, 1, 1);
        TimeSpan ts = new TimeSpan(excelDays, 0, 0, 0);
        DateTime D = start.Add(ts);

        double open = Convert.ToDouble(nextValue(reader));
        double high = Convert.ToDouble(nextValue(reader));
        double low = Convert.ToDouble(nextValue(reader));
        double close = Convert.ToDouble(nextValue(reader));
        double volume = Convert.ToDouble(nextValue(reader));

        StockData S = new StockData(D, close);
        return S;
    }

}

