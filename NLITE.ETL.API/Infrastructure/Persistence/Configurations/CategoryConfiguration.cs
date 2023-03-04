using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using NLITE.ETL.API.Domain.Entities;

namespace NLITE.ETL.API.Infrastructure.Persistence.Configurations;

public class CategoryConfiguration : IEntityTypeConfiguration<Category>
{
    public void Configure(EntityTypeBuilder<Category> builder)
    {
        builder.Property(p => p.Code)
            .HasMaxLength(250)
            .IsRequired();

        builder.Property(p => p.Description)
         .HasMaxLength(250)
         .IsRequired();
    }
}