namespace NLITE.ETL.API.Domain.Entities;

public class GameMatric : BaseEntity
{
    public GameMatric(Guid categoryId, int minimum, int maximum, int score)
    {
        CategoryId = categoryId;
        Minimum = minimum;
        Maximum = maximum;
        Score = score;
    }

    public Guid CategoryId { get; private set; }
    public Category? Category { get; private set; }

    public int Minimum { get; private set; }
    public int Maximum { get; private set; }
    public int Score { get; private set; }

    public string? Name => Category?.Description;
}
