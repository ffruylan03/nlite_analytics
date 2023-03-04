using NLITE.ETL.API.Domain.Entities;
using NLITE.ETL.API.Helpers;
using TinyCsvParser;
using TinyCsvParser.Mapping;

namespace NLITE.ETL.API.Features.GameMatrics;

public class CategoryCsvMapping
{
    public class CsvHeader
    {
        public string Code { get; set; } = string.Empty;
        public string Decription { get; set; } = string.Empty;
    }

    public class CsvHeaderMapping : CsvMapping<CsvHeader>
    {
        public CsvHeaderMapping()
            : base()
        {
            MapProperty(0, p => p.Code);
            MapProperty(1, p => p.Decription);
        }
    }

    public IEnumerable<CsvHeader> GetCsvData()
    {
        var csvString = CsvHelper.GetCSVFromUrl("https://raw.githubusercontent.com/ffruylan03/nlite_analytics/main/docs/categories.csv");
        var csvParserOptions = new CsvParserOptions(false, ',');
        var csvMapper = new CsvHeaderMapping();
        var csvReaderOptions = new CsvReaderOptions(new[] { "\n" });
        var csvParser = new CsvParser<CsvHeader>(csvParserOptions, csvMapper);

        var result = csvParser
            .ReadFromString(csvReaderOptions, csvString)
            .ToList();

        return result.Select(p => p.Result); ;
    }

    public IEnumerable<Category> GetEntityData() => GetCsvData().Select(p => new Category(p.Code, p.Decription));
}
