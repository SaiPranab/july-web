import React from 'react';
import { NavLink, useRouteError } from 'react-router-dom';
import styles from "./ErrorPage.module.css";

const ErrorPage = () => {
    
    const error = useRouteError();

    return (
        <div className={`${styles["error-page"]}`}>
           
            <h1>Oops!</h1>
            <h1>Something went wrong</h1>
            <p>Sorry, an unexpected error has occurred.</p>
            
            {/* Displaying Error Details */}
            <div className='error-details'>
              
                <p className= {`${styles["error"]}`}>
                    {error.status || 'N/A'}
                </p>
                <p>
                    {error.statusText|| error.data || error.message || 'No specific error message available.'}
                </p>
            </div>
            
            {/* Navigation Prompt */}
            <p className='navigation-prompt'>
                Please try again or navigate back to the home page.
            </p>
            <NavLink to="/" className={`${styles["redirection"]}`}>   
                  Go Back To Home Page
            </NavLink>
            {/* btn btn-warning, btn btn-info, btn btn-dark, btn btn-success */}
        </div>
    );
}

export default ErrorPage;
