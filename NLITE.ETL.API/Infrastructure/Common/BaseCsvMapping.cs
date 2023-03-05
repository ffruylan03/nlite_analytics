using NLITE.ETL.API.Domain.Entities;
using System.Text;
using TinyCsvParser;
using TinyCsvParser.Mapping;

namespace NLITE.ETL.API.Infrastructure.Common;

public abstract class BaseCsvMapping<T> : CsvMapping<T> where T : class, new()
{
    protected BaseCsvMapping()
    {
        Configure();
    }

    protected abstract void Configure();

    protected IEnumerable<T> GetCsvData(string filename)
    {
        string filepath = Path.Combine(Directory.GetCurrentDirectory(), "wwwroot", "files", "seed", filename);
        using var fileStream = new FileStream(filepath, FileMode.Open);
        using var memoryStream = new MemoryStream();

        // Copy the data from the file stream to the memory stream
        fileStream.CopyTo(memoryStream);

        var csvParserOptions = new CsvParserOptions(true, ',');
        var csvParser = new CsvParser<T>(csvParserOptions, this);

        // Reset the position of the memory stream to the beginning
        memoryStream.Position = 0;

        var records = csvParser.ReadFromStream(memoryStream, Encoding.UTF8);
        var results = records.Select(x => x.Result).ToList();
        return results;
    }

    public abstract IEnumerable<BaseEntity> GetEntityData();

}
