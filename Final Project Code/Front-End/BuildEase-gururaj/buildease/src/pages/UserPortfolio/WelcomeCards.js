import React, { useState } from "react";
import "./WelcomeCards.css"; // Import CSS for styling

// Import images
import image1 from "../../assets/image1.jpg";
import image2 from "../../assets/image2.jpg";
import image3 from "../../assets/image3.jpg";
import image4 from "../../assets/image4.jpg";
import image5 from "../../assets/image5.jpg";
import image6 from "../../assets/image6.jpg";
import image7 from "../../assets/image7.jpg";
import image8 from "../../assets/image8.jpg";
import image9 from "../../assets/image9.jpg";
import image10 from "../../assets/image10.jpg";
import image11 from "../../assets/image11.jpg";
import image12 from "../../assets/image12.jpg";

const WelcomeCards = () => {
  const allCards = [
    {
      id: 1,
      title: "Card Title 1",
      description: "This is a description for card number 1.",
      imageUrl: image1,
    },
    {
      id: 2,
      title: "Card Title 2",
      description: "This is a description for card number 2.",
      imageUrl: image2,
    },
    {
      id: 3,
      title: "Card Title 3",
      description: "This is a description for card number 3.",
      imageUrl: image3,
    },
    {
      id: 4,
      title: "Card Title 4",
      description: "This is a description for card number 4.",
      imageUrl: image4,
    },
    {
      id: 5,
      title: "Card Title 5",
      description: "This is a description for card number 5.",
      imageUrl: image5,
    },
    {
      id: 6,
      title: "Card Title 6",
      description: "This is a description for card number 6.",
      imageUrl: image6,
    },
    {
      id: 7,
      title: "Card Title 7",
      description: "This is a description for card number 7.",
      imageUrl: image7,
    },
    {
      id: 8,
      title: "Card Title 8",
      description: "This is a description for card number 8.",
      imageUrl: image8,
    },
    {
      id: 9,
      title: "Card Title 9",
      description: "This is a description for card number 9.",
      imageUrl: image9,
    },
    {
      id: 10,
      title: "Card Title 10",
      description: "This is a description for card number 10.",
      imageUrl: image10,
    },
    {
      id: 11,
      title: "Card Title 11",
      description: "This is a description for card number 11.",
      imageUrl: image11,
    },
    {
      id: 12,
      title: "Card Title 12",
      description: "This is a description for card number 12.",
      imageUrl: image12,
    },
  ];

  const cardsPerPage = 6;
  const [currentPage, setCurrentPage] = useState(0);

  const startIndex = currentPage * cardsPerPage;
  const currentCards = allCards.slice(startIndex, startIndex + cardsPerPage);
  const totalPages = Math.ceil(allCards.length / cardsPerPage);

  const handleNext = () => {
    if (currentPage < totalPages - 1) {
      setCurrentPage(currentPage + 1);
    }
  };

  const handlePrevious = () => {
    if (currentPage > 0) {
      setCurrentPage(currentPage - 1);
    }
  };

  return (
    <div className="welcome-cards-container">
      <div className="cards-grid">
        {currentCards.map((card) => (
          <div key={card.id} className="card">
            <img src={card.imageUrl} alt={card.title} className="card-image" />
            <div className="card-content">
              <h3 className="card-title">{card.title}</h3>
              <p className="card-description">{card.description}</p>
            </div>
          </div>
        ))}
      </div>
      <div className="pagination-controls">
        <button
          onClick={handlePrevious}
          disabled={currentPage === 0}
          className="pagination-button"
        >
          Previous
        </button>
        <button
          onClick={handleNext}
          disabled={currentPage === totalPages - 1}
          className="pagination-button"
        >
          Next
        </button>
      </div>
    </div>
  );
};

export default WelcomeCards;
