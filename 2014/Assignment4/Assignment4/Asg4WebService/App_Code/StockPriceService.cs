using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

// NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service" in code, svc and config file together.
public class StockPriceService : IStockPriceService
{
    private string strPath = "http://users.cis.fiu.edu/~irvinek/cop4814/data/ulti.xml";

    public StockData[] GetDateRange(DateTime start, DateTime stop)
    {
        if (start == null || stop == null)
            throw new NullReferenceException();
        List<StockData> lstStockDataInput = StockReader.Read(strPath);
        List<StockData> lstStockDataOutput = null;
        if(lstStockDataInput!=null)
            lstStockDataOutput = new List<StockData>();

        foreach(StockData stock in lstStockDataInput){
            int before = stock.ClosingDate.CompareTo(start);//if start is earlier than stock date get -1
            int after = stop.CompareTo(stock.ClosingDate);//if stock date is after stop get -1
            if(before>0 && after>0)
                lstStockDataOutput.Add(stock);
        }
           
        return lstStockDataOutput.ToArray();
    }

    public StockData GetMovingAverage(int days)
    {
        throw new NotImplementedException();
    }
}
