using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using NLITE.ETL.API.Domain.Entities;

namespace NLITE.ETL.API.Infrastructure.Persistence.Configurations;

public class GameMetricConfiguration : IEntityTypeConfiguration<GameMetric>
{
    public void Configure(EntityTypeBuilder<GameMetric> builder)
    {
        builder.HasOne(x => x.Category)
            .WithMany(x => x.Matrics)
            .HasForeignKey(x => x.CategoryId);

        builder.HasIndex(x => x.CategoryId);
    }
}
