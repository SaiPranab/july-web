import styles from "./footer.module.css"

const Footer = () => {
  return (
    <footer className="bg-dark text-white py-3 ">
      <div className="container">
        <div className="row text-center text-md-start">
          {/* Brand & Social */}
          <div className="col-12 col-md-3 ">
            <h5 className="text-primary">Tasty Town</h5>
            <div className="d-flex justify-content-center justify-content-md-start gap-3 mt-3">
              <a href="#" className={`text-white fs-4 ${styles.link}`}><i className="bi bi-facebook"></i></a>
              <a href="#" className={`text-white fs-4 ${styles.link}`}><i className="bi bi-instagram"></i></a>
              <a href="#" className={`text-white fs-4 ${styles.link}`}><i className="bi bi-twitter-x"></i></a>
            </div>
          </div>

          {/* Services */}
          <div className="col-6 col-md-3 mb-4">
            <h5 className="text-primary">Services</h5>
            <ul className="list-unstyled">
              <li className={`${styles.list}`}><a href="#" className={`text-white text-decoration-none d-block mb-2 ${styles.link}`}>Delivery</a></li>
              <li className={`${styles.list}`}><a href="#" className={`text-white text-decoration-none d-block mb-2 ${styles.link}`}>Pricing</a></li>
              <li className={`${styles.list}`}><a href="#" className={`text-white text-decoration-none d-block mb-2 ${styles.link}`}>Fast food</a></li>
              <li className={`${styles.list}`}><a href="#" className={`text-white text-decoration-none d-block mb-2 ${styles.link}`}>Reserve your spot</a></li>
            </ul>
          </div>

          {/* Info */}
          <div className="col-6 col-md-3 ">
            <h5 className="text-primary">Information</h5>
            <ul className="list-unstyled">
              <li className={`${styles.list}`}><a href="#" className={`text-white text-decoration-none d-block mb-2 ${styles.link}`}>Event</a></li>
              <li className={`${styles.list}`}><a href="#" className={`text-white text-decoration-none d-block mb-2 ${styles.link}`}>Contact us</a></li>
              <li className={`${styles.list}`}><a href="#" className={`text-white text-decoration-none d-block mb-2 ${styles.link}`}>Privacy policy</a></li>
              <li className={`${styles.list}`}><a href="#" className={`text-white text-decoration-none d-block mb-2 ${styles.link}`}>Terms of service</a></li>
            </ul>
          </div>

          {/* Address */}
          <div className="col-12 col-md-3 ">
            <h5 className="text-primary">Address</h5>
            <ul className="list-unstyled">
              <li className={`${styles.list} mb-2`} >Test Street</li>
              <li className={`${styles.list} mb-2`} >Colombo</li>
              <li className={`${styles.list} mb-2`} >011-000-0000</li>
              <li className={`${styles.list} mb-2`} >test@email.com</li>
            </ul>
          </div>
        </div>

        <div className="text-center mb-1">
          <p>&copy; TastyTown. All rights reserved.</p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;