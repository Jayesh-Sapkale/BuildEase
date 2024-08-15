import React, { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "./SignUpUpdated.css";

import UserTypeSelect from "./UserTypeSelect";
import AddressDetails from "./AddressDetails";
import BasicDetails from "./BasicDetails";
import ContactDetails from "./ContactDetails";
import BuilderDetails from "./BuilderDetails";

const SignUp = () => {
  const history = useHistory();

  const [formData, setFormData] = useState({
    userName: "",
    password: "",
    confirmPassword: "",
    address: {
      adrLine1: "",
      adrLine2: "",
      city: "",
      state: "",
      country: "",
      zipcode: "",
    },
    basicDetails: {
      firstName: "",
      lastName: "",
      birthDate: "",
      gender: "",
    },
    contactDetails: {
      contactNumber: "",
      email: "",
      url: "",
    },
    yearsOfExperience: "",
    ratePerMonth: "",
    constructionType: "WAREHOUSE",
    emergencyContactNumber: "",
    availability: "YES",
    userType: "customer", // Default to 'customer'
  });

  const [formErrors, setFormErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;

    if (name.includes(".")) {
      const [section, field] = name.split(".");
      setFormData((prevData) => ({
        ...prevData,
        [section]: {
          ...prevData[section],
          [field]: value,
        },
      }));
    } else {
      setFormData((prevData) => ({
        ...prevData,
        [name]: value,
      }));
    }
  };

  const validateField = (name, value) => {
    let errors = { ...formErrors };

    if (name.includes(".")) {
      const [section, field] = name.split(".");
      errors = {
        ...errors,
        [section]: {
          ...errors[section],
          [field]: value.trim() === "" ? `${field} is required` : "",
        },
      };
    } else {
      errors = {
        ...errors,
        [name]: value.trim() === "" ? `${name} is required` : "",
      };
    }

    setFormErrors(errors);
  };

  const handleBlur = (e) => {
    const { name, value } = e.target;
    validateField(name, value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const errors = {};
    const requiredFields = ["userName", "password", "confirmPassword"];

    requiredFields.forEach((field) => {
      if (!formData[field]) {
        errors[field] = `${field} is required`;
      }
    });

    if (formData.password !== formData.confirmPassword) {
      errors.confirmPassword = "Passwords do not match";
    }

    setFormErrors(errors);

    if (Object.keys(errors).length > 0) {
      return;
    }

    const url = formData.userType === "builder"
      ? "http://localhost:8081/builder/signUp"
      : "http://localhost:8081/customer/signUp";

    try {
      const response = await axios.post(url, formData);
      if (response.status === 201) {
        toast.success("Sign up successful!");

        // Add a delay before redirecting to the sign-in page
        setTimeout(() => {
          history.push("/signin");
        }, 5000); // 5 seconds delay
      }
    } catch (error) {
      toast.error("Sign up failed. Please try again.");
    }
  };

  const isBuilder = formData.userType === "builder";

  return (
    <div className="signUpContainer">
      <button
        type="button"
        className="back"
        onClick={() => history.goBack()}
      >
        ⬅
      </button>
      <h2>Sign Up</h2>
      <form onSubmit={handleSubmit}>
        <UserTypeSelect userType={formData.userType} onChange={handleChange} />
        <input
          type="text"
          name="userName"
          value={formData.userName}
          onChange={handleChange}
          onBlur={handleBlur}
          placeholder="Username"
        />
        {formErrors.userName && <div className="error">{formErrors.userName}</div>}
        <input
          type="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          onBlur={handleBlur}
          placeholder="Password"
        />
        {formErrors.password && <div className="error">{formErrors.password}</div>}
        <input
          type="password"
          name="confirmPassword"
          value={formData.confirmPassword}
          onChange={handleChange}
          onBlur={handleBlur}
          placeholder="Confirm Password"
        />
        {formErrors.confirmPassword && <div className="error">{formErrors.confirmPassword}</div>}

        <AddressDetails
          address={formData.address}
          onChange={handleChange}
          onBlur={handleBlur}
          errors={formErrors.address || {}}
        />
        <BasicDetails
          basicDetails={formData.basicDetails}
          onChange={handleChange}
          onBlur={handleBlur}
          errors={formErrors.basicDetails || {}}
        />
        <ContactDetails
          contactDetails={formData.contactDetails}
          onChange={handleChange}
          onBlur={handleBlur}
          errors={formErrors.contactDetails || {}}
        />

        {isBuilder && (
          <BuilderDetails
            builderDetails={formData}
            onChange={handleChange}
            onBlur={handleBlur}
            errors={formErrors}
          />
        )}

        <button type="submit" className="signUpButton">
          Sign Up
        </button>
      </form>
      <ToastContainer />
    </div>
  );
};

export default SignUp;
