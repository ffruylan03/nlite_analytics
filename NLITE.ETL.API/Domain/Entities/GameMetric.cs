namespace NLITE.ETL.API.Domain.Entities;

public class GameMetric : BaseEntity
{
    public GameMetric(Guid categoryId, decimal minimum, decimal maximum, int score)
    {
        CategoryId = categoryId;
        Minimum = minimum;
        Maximum = maximum;
        Score = score;
    }

    public Guid CategoryId { get; private set; }
    public Category? Category { get; private set; }

    public decimal Minimum { get; private set; }
    public decimal Maximum { get; private set; }
    public int Score { get; private set; }

    public string? Name => Category?.Description;
}
