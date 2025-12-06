import FoodSection from "@/components/customer/food section/FoodSection";
import Header from "@/components/customer/header/Header";
import Parallax from "@/components/customer/parallax/PArallax";

export default function Home() {
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