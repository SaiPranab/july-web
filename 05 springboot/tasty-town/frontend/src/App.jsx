import Footer from "./components/customer/footer/Footer";
import Navbar from "./components/customer/navbar/Navbar";
import Home from "./pages/home/Home";

function App() {
  return (
    <>
      <div className="brand-logo text-center my-3 fade-slide-in">
        <h1 className="logo-text">Tasty Town</h1>
        <p className="logo-tagline">Deliciousness Delivered</p>
      </div>

      {/* Navbar */}
      <Navbar />

      {/* Landing Page */}
      <Home />

      {/* Footer */}
      <Footer />
    </>
  );
}

export default App;
