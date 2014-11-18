using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

// NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService" in both code and config file together.
[ServiceContract]
public interface IStockPriceService
{

	[OperationContract]
	StockData[] GetDateRange(DateTime start, DateTime stop);

	[OperationContract]
	StockData GetMovingAverage(int days);

}

// Use a data contract as illustrated in the sample below to add composite types to service operations.
[DataContract]
public class StockData
{
    public StockData(DateTime closingDate, double closingPrice)
    {
        ClosingDate = closingDate;
        ClosingPrice = closingPrice;
    }
	[DataMember]
	public DateTime ClosingDate{ get; set; }

    [DataMember]
    public double ClosingPrice { get; set; }
}
