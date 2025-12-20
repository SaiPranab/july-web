import FoodSection from "@/components/customer/food section/FoodSection";
import Header from "@/components/customer/header/Header";
import Parallax from "@/components/customer/parallax/PArallax";

import { useEffect } from "react";
import Lenis from "lenis";
import Footer from "@/components/customer/footer/Footer";

export default function Home() {

  useEffect(() => {
    const lenis = new Lenis({
      // infinite: true,
      duration: 2.5,
    });

    function raf(time) {
      lenis.raf(time);
      // lenis.destroy();
      requestAnimationFrame(raf);
    }

    requestAnimationFrame(raf);

    return () => {
      lenis.destroy();
    };

  }, []); 

  return (
    <>
      <main className="container fade-slide-in">
        {/* Header */}
        <Header />

        {/* Food Section */}
        <FoodSection />

        {/* Parallax */}
        <Parallax />

        {/* Food Section */}
        <FoodSection />

        {/* Footer */}
        <Footer />
      </main>
    </>
  )
}