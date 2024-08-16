import React from 'react';

const Header = ({ history, toggleMenu }) => {
    return (
        <header className="builder-portfolio-header">
            <div className="builder-portfolio-back-button-container">
                <button id="back-button" onClick={() => history.goBack()}>
                    ⬅
                </button>
            </div>
            <div className="builder-portfolio-title-container">
                <h1>Builder Portfolio</h1>
            </div>
            <div className="builder-portfolio-hamburger-menu-container">
                <button id="hamburger-menu" onClick={toggleMenu}>
                    ☰
                </button>
            </div>
        </header>
    );
};

export default Header;
