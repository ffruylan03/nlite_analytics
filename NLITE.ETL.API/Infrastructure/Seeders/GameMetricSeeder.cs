using NLITE.ETL.API.Domain.Entities;
using NLITE.ETL.API.Infrastructure.Common;

namespace NLITE.ETL.API.Infrastructure.Seeders
{
    public class GameMetricSeeder : BaseCsvMapping<GameMetricSeeder.CsvHeader>
    {
        public class CsvHeader
        {
            public string Code { get; set; } = string.Empty;
            public string Description { get; set; } = string.Empty;
            public decimal Minimum { get; set; }
            public decimal Maximum { get; set; }
            public int Score { get; set; }
        }

        protected override void Configure()
        {
            MapProperty(0, p => p.Code);
            MapProperty(1, p => p.Description);
            MapProperty(2, p => p.Minimum);
            MapProperty(3, p => p.Maximum);
            MapProperty(4, p => p.Score);
        }

        public override IEnumerable<BaseEntity> GetEntityData()
        {
            throw new NotImplementedException();
        }

        public IEnumerable<GameMetric> GetEntityData(IEnumerable<Category> categories)
        {
            var gamemetrics = GetCsvData("GameMetricKey.csv");
            var metrics = gamemetrics.Join(categories, a => a?.Description, b => b?.Description, (a, b) => new GameMetric(b.Id, a.Minimum, a.Maximum, a.Score)).ToList();

            return metrics;
        }
    }
}
