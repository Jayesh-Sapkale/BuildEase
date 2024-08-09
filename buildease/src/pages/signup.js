import React, { useState } from "react";
import "./signup.css";
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";

const SignUp = () => {
  const history = useHistory();

  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    contactNumber: "",
    dateOfBirth: "",
    gender: "",
    email: "",
    password: "",
    confirmPassword: "",
  });

  const [formErrors, setFormErrors] = useState({});
  const [successMessage, setSuccessMessage] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const validate = () => {
    let errors = {};

    if (!formData.firstName.trim()) {
      errors.firstName = "First Name is required";
    }
    if (!formData.lastName.trim()) {
      errors.lastName = "Last Name is required";
    }

    const phoneRegex = /^[0-9]{10}$/;
    if (!formData.contactNumber.trim()) {
      errors.contactNumber = "Contact Number is required";
    } else if (!phoneRegex.test(formData.contactNumber)) {
      errors.contactNumber = "Contact Number must be 10 digits";
    }

    if (!formData.dateOfBirth.trim()) {
      errors.dateOfBirth = "Date of Birth is required";
    }

    if (!formData.gender) {
      errors.gender = "Gender is required";
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!formData.email.trim()) {
      errors.email = "Email is required";
    } else if (!emailRegex.test(formData.email)) {
      errors.email = "Invalid email address";
    }

    if (!formData.password.trim()) {
      errors.password = "Password is required";
    } else if (formData.password.length < 6) {
      errors.password = "Password must be at least 6 characters";
    }

    if (!formData.confirmPassword.trim()) {
      errors.confirmPassword = "Confirm Password is required";
    } else if (formData.password !== formData.confirmPassword) {
      errors.confirmPassword = "Passwords do not match";
    }

    setFormErrors(errors);
    return Object.keys(errors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      console.log("Form data is valid. Submitting the form...");
      setSuccessMessage("Successfully signed up!");

      setFormData({
        firstName: "",
        lastName: "",
        contactNumber: "",
        dateOfBirth: "",
        gender: "",
        email: "",
        password: "",
        confirmPassword: "",
      });

      setFormErrors({});
    }
  };

  return (
    <div id="signUpWrapper">
      <div id="signUpContainer">
        <button
          type="button"
          className="back hoverEffect"
          onClick={() => history.goBack()}
        >
          Back
        </button>
        <form onSubmit={handleSubmit}>
          <h2 id="title">Sign Up</h2>
          <div id="signUpInputs">
            <div className="formRow">
              <div className="formGroup halfWidth">
                <input
                  type="text"
                  id="firstName"
                  name="firstName"
                  placeholder="First Name"
                  value={formData.firstName}
                  onChange={handleChange}
                  required
                />
                {formErrors.firstName && (
                  <p className="error">{formErrors.firstName}</p>
                )}
              </div>
              <div className="formGroup halfWidth">
                <input
                  type="text"
                  id="lastName"
                  name="lastName"
                  placeholder="Last Name"
                  value={formData.lastName}
                  onChange={handleChange}
                  required
                />
                {formErrors.lastName && (
                  <p className="error">{formErrors.lastName}</p>
                )}
              </div>
            </div>
            <div className="formRow">
              <div className="formGroup halfWidth">
                <input
                  type="tel"
                  id="contactNumber"
                  name="contactNumber"
                  placeholder="Contact Number"
                  value={formData.contactNumber}
                  onChange={handleChange}
                  required
                />
                {formErrors.contactNumber && (
                  <p className="error">{formErrors.contactNumber}</p>
                )}
              </div>
              <div className="formGroup halfWidth">
                <input
                  type="date"
                  id="dateOfBirth"
                  name="dateOfBirth"
                  placeholder="Date of Birth"
                  value={formData.dateOfBirth}
                  onChange={handleChange}
                  required
                />
                {formErrors.dateOfBirth && (
                  <p className="error">{formErrors.dateOfBirth}</p>
                )}
              </div>
            </div>
            <div className="formRow">
              <div className="formGroup">
                <div id="gender">
                  <label htmlFor="male">Male</label>
                  <input
                    type="radio"
                    id="male"
                    name="gender"
                    value="Male"
                    checked={formData.gender === "Male"}
                    onChange={handleChange}
                    required
                  />
                  <label htmlFor="female">Female</label>
                  <input
                    type="radio"
                    id="female"
                    name="gender"
                    value="Female"
                    checked={formData.gender === "Female"}
                    onChange={handleChange}
                    required
                  />
                </div>
                {formErrors.gender && (
                  <p className="error">{formErrors.gender}</p>
                )}
              </div>
            </div>
            <div className="formRow">
              <div className="formGroup halfWidth">
                <input
                  type="email"
                  id="signUpEmail"
                  name="email"
                  placeholder="Email"
                  value={formData.email}
                  onChange={handleChange}
                  required
                />
                {formErrors.email && (
                  <p className="error">{formErrors.email}</p>
                )}
              </div>
              <div className="formGroup halfWidth">
                <input
                  type="password"
                  id="signUpPassword"
                  name="password"
                  placeholder="Password"
                  value={formData.password}
                  onChange={handleChange}
                  required
                />
                {formErrors.password && (
                  <p className="error">{formErrors.password}</p>
                )}
              </div>
            </div>
            <div className="formRow">
              <div className="formGroup fullWidth">
                <input
                  type="password"
                  id="signUpPasswordConfirm"
                  name="confirmPassword"
                  placeholder="Confirm Password"
                  value={formData.confirmPassword}
                  onChange={handleChange}
                  required
                />
                {formErrors.confirmPassword && (
                  <p className="error">{formErrors.confirmPassword}</p>
                )}
              </div>
            </div>
            <button type="submit" className="button hoverEffect shake">
              SIGN UP
            </button>
          </div>
        </form>
        {successMessage && <p className="success">{successMessage}</p>}
      </div>
    </div>
  );
};

export default SignUp;
