// src/components/SignIn.js
import React, { useState } from "react";
import { useHistory, Link } from "react-router-dom";
import axios from "axios";
import "./signin.css";
import "@fortawesome/fontawesome-free/css/all.min.css";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const SignIn = ({ closeSignIn }) => {
  // Removed setRole
  const [userName, setuserName] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [errors, setErrors] = useState({});
  const [role, updateRole] = useState("Admin"); // Default role is Admin
  const history = useHistory();

  const validatePassword = (password) => {
    return password.length >= 6;
  };

  const handleSignIn = async (e) => {
    e.preventDefault();
    let valid = true;
    let errors = {};

    if (!validatePassword(password)) {
      errors.password = "Password must be at least 6 characters.";
      valid = false;
    }

    setErrors(errors);

    if (valid) {
      const signInDto = {
        userName: userName,
        password: password,
      };

      try {
        await toast.promise(
          axios.post(`http://localhost:8081/signIn/${role}`, signInDto, {
            headers: {
              "Content-Type": "application/json",
            },
          }),
          {
            pending: "Signing in...",
            success: "Sign-in successful! Redirecting...",
            error: "Sign-in failed. Please check your credentials.",
          }
        );

        history.push(`/IndexAfterSignin/${role}`); // Redirect after successful sign-in
      } catch (error) {
        console.error("There was an error!", error);
      }
    }
  };

  const handleSignUpClick = () => {
    console.log("Sign Up button clicked");
    history.push("/signup");
  };

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div id="signInWrapper">
      <div id="signInContainer">
        <button
          type="button"
          className="back hoverEffect"
          onClick={closeSignIn}
        >
          ⬅
        </button>
        <form onSubmit={handleSignIn}>
          <h2 id="title">Login</h2>
          <p id="alternativeSignIn">or use your user name & password</p>
          <input
            type="text"
            required
            placeholder="User Name"
            name="signInuserName"
            id="signInuserName"
            value={userName}
            onChange={(e) => setuserName(e.target.value)}
          />
          {errors.userName && <p className="error">{errors.userName}</p>}
          <div className="password-container">
            <input
              type={showPassword ? "text" : "password"}
              required
              placeholder="Password"
              name="signInPassword"
              id="signInPassword"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <i
              className={`fa ${
                showPassword ? "fa-eye-slash" : "fa-eye"
              } password-icon`}
              onClick={togglePasswordVisibility}
            ></i>
          </div>
          {errors.password && <p className="error">{errors.password}</p>}

          <label className="role-label">
            Sign-In As:
            <select
              name="role"
              id="role"
              value={role}
              onChange={(e) => updateRole(e.target.value)}
            >
              <option value="Admin">Admin</option>
              <option value="Builder">Builder</option>
              <option value="Customer">Customer</option>
            </select>
          </label>
          <button type="submit" id="signInSubmit">
            Sign In
          </button>
          <p id="forgot">Forgot your password?</p>
          <Link to="/signup" onClick={handleSignUpClick} id="signUpLink">
            <p id="newUser">New User?</p>
          </Link>
        </form>
      </div>
      <ToastContainer />
    </div>
  );
};

export default SignIn;
