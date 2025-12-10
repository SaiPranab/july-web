import React, { useRef } from 'react'; 
import Slider from 'react-slick';
import styles from "./Header.module.css";


import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';


import header1 from "@assets/images/header.png"; 
import header2 from "@assets/images/image2.png"; 
import header3 from "@assets/images/image3.png";
import header4 from "@assets/images/image4.png";
import header5 from "@assets/images/image5.png"; 




// --- Define Slide Data 
const slidesData = [
  { 
    headline: 'Order your favorite food here', 
    subtext: 'Discover the best food and drinks in Town', 
    image: header1 
  },
  { 
    headline: '🔥 Flash Sale: Get 20% Off Pizzas!', 
    subtext: 'Use code **PIZZA20** at checkout. Limited time offer!', 
    image: header2 
  },
  { 
    headline: 'Hydrabadi Biriyani', 
    subtext: 'Get the real test of hydrabadi biriyani in your home.', 
    image: header3
  },
  { 
    headline: 'Fresh Options Delivered', 
    subtext: 'Explore the most authentic dishes of your town.', 
    image: header4
  },
  { 
    headline: 'Sweet Delights', 
    subtext: 'Indulge in moments of sugary bliss.', 
    image: header5
  },
   
];

// --- Define Settings for the Carousel (Updated) ---
const settings = {
  dots: true,
  infinite: true,
  speed: 800,
  slidesToShow: 1,
  slidesToScroll: 1,
  autoplay: true,
  autoplaySpeed: 5000,
  arrows: false,
    
  // 👇 ADDED: Custom indicator/paging logic
  customPaging: function(i) {
    return (
      <div className={styles.customDot}>
        
      </div>
    );
  },
  appendDots: dots => (
    <div
      style={{
        position: "absolute",
        bottom: "20px", // Position the dots 20px from the bottom
        width: "100%",
        display: "flex",
        justifyContent: "center",
        zIndex: 5, // Ensure dots are above other elements
      }}
    >
      <ul style={{ margin: "0px" }}> {dots} </ul>
    </div>
  )
};


export default function Header() {
  // Create a ref to attach to the Slider component
  const sliderRef = useRef(null); 

  // Function to move to the next slide
  const nextSlide = () => {
    if (sliderRef.current) {
      sliderRef.current.slickNext();
    }
  };

  // Function to move to the previous slide
  const prevSlide = () => {
    if (sliderRef.current) {
      sliderRef.current.slickPrev();
    }
  };
  
  // Custom Slide Component (remains the same)
  const CarouselSlide = ({ headline, subtext, image }) => (
    <div 
      className={styles.slideContent} 
      style={{ backgroundImage: `url(${image})` }}
    >
      <div className="container-fluid py-5">
        <h1 className="display-5 fw-bold">{headline}</h1>
        <p className="col-md-8 fs-4">{subtext}</p>
        
        <a href="/explore" className="btn btn-primary">
          Explore
        </a>
        
      </div>
    </div>
  );
  

  return (
    // Main container is relative to position the absolute buttons
    <div className={`p-0 mb-4 rounded-4 mt-1 ${styles.headerContainer}`}>
      
      <Slider {...settings} ref={sliderRef}>
        {slidesData.map((slide, index) => (
          <CarouselSlide
            key={index}
            headline={slide.headline}
            subtext={slide.subtext}
            image={slide.image}
          />
        ))}
      </Slider>

      {/* --- CUSTOM NAVIGATION BUTTONS --- */}
      <button 
        className={styles.prevButton} 
        onClick={prevSlide}
        aria-label="Previous Slide"
      >
        &#10094; {/* Left arrow Unicode character */}
      </button>
      
      <button 
        className={styles.nextButton} 
        onClick={nextSlide}
        aria-label="Next Slide"
      >
        &#10095; {/* Right arrow Unicode character */}
      </button>

    </div>
  );
}