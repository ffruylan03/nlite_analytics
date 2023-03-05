using NLITE.ETL.API.Domain.Entities;
using NLITE.ETL.API.Infrastructure.Common;

namespace NLITE.ETL.API.Infrastructure.Seeders;

public class CategorySeeder : BaseCsvMapping<CategorySeeder.CsvHeader>
{
    public class CsvHeader
    {
        public string Code { get; set; } = string.Empty;
        public string Description { get; set; } = string.Empty;
    }

    protected override void Configure()
    {
        MapProperty(0, p => p.Code);
        MapProperty(1, p => p.Description);
    }

    public override IEnumerable<Category> GetEntityData()
    {
        return GetCsvData("categories.csv").Select(p => new Category(p.Code, p.Description));
    }
}
