import FoodSection from "@/components/customer/food section/FoodSection";
import Header from "@/components/customer/header/Header";
import Parallax from "@/components/customer/parallax/PArallax";

import { useEffect } from "react";
import Lenis from "lenis";

export default function Home() {

  useEffect(() => {
    const lenis = new Lenis({
      // infinite: true,
      duration: 1.2,
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
      <main className="container">
        {/* Header */}
        <Header />

        {/* Food Section */}
        <FoodSection />

        {/* Parallax */}
        <Parallax />

        {/* Food Section */}
        <FoodSection />
      </main>
    </>
  )
}