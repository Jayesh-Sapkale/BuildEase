import React from "react";

const SignOut = () => {
    return (
        <div className="table-container">
            <section>
                <h2>Sign Out</h2>
                <p>
                    You have been signed out. Please <a href="/login">log in again</a>.
                </p>
            </section>
        </div>
    );
};

export default SignOut;
