namespace NLITE.ETL.API.Domain.Entities;

public class BaseEntity
{

    public BaseEntity()
    {
        Created = DateTime.UtcNow;
    }

    public int Id { get; set; }
    public DateTime Created { get; set; }
}
