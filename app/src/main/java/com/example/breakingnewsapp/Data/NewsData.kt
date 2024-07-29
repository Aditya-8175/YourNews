package com.example.breakingnewsapp.Data

data class News(
    val id: String,
    val title: String,
    val description: String,
    val author: String,
    val date: String,
    val category: String,
    val image: String
)
fun getNews(): List<News> {
    return listOf(
        News(
            id = "1",
            title = "Breaking News: Market Hits Record High",
            description = "The stock market reached an all-time high today as investors reacted positively to the latest economic data.",
            author = "Jane Doe",
            date = "2024-05-29",
            category = "Economy",
            image = "https://example.com/images/market_high.jpg"
        ),
        News(
            id = "2",
            title = "Sports Update: Local Team Wins Championship",
            description = "The local football team won the national championship in a thrilling match that went into overtime.",
            author = "John Smith",
            date = "2024-05-28",
            category = "Sports",
            image = "https://example.com/images/championship_win.jpg"
        ),
        News(
            id = "3",
            title = "Tech Innovations: New Smartphone Released",
            description = "A leading tech company released its latest smartphone model today, featuring groundbreaking new technology.",
            author = "Emily Johnson",
            date = "2024-05-27",
            category = "Technology",
            image = "https://example.com/images/new_smartphone.jpg"
        ),
        News(
            id = "4",
            title = "Health Alert: New Guidelines for Healthy Living",
            description = "Health experts have released new guidelines for maintaining a healthy lifestyle, emphasizing the importance of diet and exercise.",
            author = "Michael Brown",
            date = "2024-05-26",
            category = "Health",
            image = "https://example.com/images/healthy_living.jpg"
        ),
        News(
            id = "5",
            title = "Entertainment: Award-Winning Movie Premieres",
            description = "An award-winning movie premiered last night, receiving rave reviews from critics and audiences alike.",
            author = "Sarah Wilson",
            date = "2024-05-25",
            category = "Entertainment",
            image = "https://example.com/images/movie_premiere.jpg"
        ),
        News(
            id = "6",
            title = "World News: Historic Peace Agreement Signed",
            description = "A historic peace agreement was signed today, bringing an end to decades of conflict in the region.",
            author = "David Lee",
            date = "2024-05-24",
            category = "World",
            image = "https://example.com/images/peace_agreement.jpg"
        ),
        News(
            id = "7",
            title = "Local News: Community Garden Flourishes",
            description = "The community garden project has seen great success, with local residents contributing to and benefiting from the fresh produce.",
            author = "Linda Martinez",
            date = "2024-05-23",
            category = "Local",
            image = "https://example.com/images/community_garden.jpg"
        ),
        News(
            id = "8",
            title = "Finance: Tips for Saving Money",
            description = "Financial experts share their top tips for saving money and planning for the future.",
            author = "Robert Garcia",
            date = "2024-05-22",
            category = "Finance",
            image = "https://example.com/images/saving_money.jpg"
        ),
        News(
            id = "9",
            title = "Science: New Discovery in Space",
            description = "Astronomers have made a new discovery in space, shedding light on the origins of the universe.",
            author = "Jessica Hernandez",
            date = "2024-05-21",
            category = "Science",
            image = "https://example.com/images/space_discovery.jpg"
        ),
        News(
            id = "10",
            title = "Travel: Top Destinations for 2024",
            description = "Travel experts list the top destinations to visit in 2024, offering tips and insights for each location.",
            author = "Kevin White",
            date = "2024-05-20",
            category = "Travel",
            image = "https://example.com/images/top_destinations.jpg"
        )
    )
}

