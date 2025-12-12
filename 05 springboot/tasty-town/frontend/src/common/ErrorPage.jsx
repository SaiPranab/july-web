import React from 'react';
import { NavLink, useRouteError } from 'react-router-dom';
import "./ErrorPage.css";

const ErrorPage = () => {
    
    const error = useRouteError();

    return (
        <div className='error-page'>
           
            <h1>Oops! Something went wrong 😥</h1>
            <p>Sorry, an unexpected error has occurred.</p>
            
            {/* Displaying Error Details */}
            <div className='error-details'>
              
                <p>
                    **Error Status:** {error.status || 'N/A'}
                </p>
                <p>
                    **Details:** **_{error.statusText|| error.data || error.message || 'No specific error message available.'}_**
                </p>
            </div>
            
            {/* Navigation Prompt */}
            <p className='navigation-prompt'>
                Please try again or navigate back to the home page.
            </p>
            <NavLink to="/" className="btn btn-primary">   
                  Go Back To Home Page
            </NavLink>
            {/* btn btn-warning, btn btn-info, btn btn-dark, btn btn-success */}
        </div>
    );
}

export default ErrorPage;
