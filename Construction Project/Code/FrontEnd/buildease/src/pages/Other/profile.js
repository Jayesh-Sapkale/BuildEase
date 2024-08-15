import React, { useState } from "react";
import styles from "./profile.module.css";
import Img1 from "../../assets/profileImages/img1.jpg";
import PropTypes from "prop-types";

const Profile = (props) => {
  const [formData, setFormData] = useState({
    firstName: "Gururaj",
    lastName: "Kamble",
    password: "********",
    email: "gurruaj@gmail.com",
    phone: "1234567890",
    address: "Ganadhish Park",
    nation: "Sangli",
    gender: "Male",
    language: "Marathi",
    dob: {
      month: "January",
      day: "21",
      year: "2000",
    },
    social: {
      twitter: "twitter.com/gururaj",
      linkedIn: "linkedin/gururaj",
      facebook: "facebook.com/gururaj",
      google: "gururaj.com",
    },
    slogan: "Project Complete Kara re Lavkar",
    paymentMethods: [
      { type: "Visa", last4: "1234", expires: "06/26" },
      { type: "MasterCard", last4: "1234", expires: "07/27" },
    ],
  });

  const [profileImage, setProfileImage] = useState(props.ProfileImg);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleImageChange = (e) => {
    if (e.target.files && e.target.files[0]) {
      setProfileImage(URL.createObjectURL(e.target.files[0]));
    }
  };

  return (
    <div className={styles.profileCard}>
      <div className={styles.profileHeader}>
        <img src={profileImage} alt="Profile" className={styles.profilePic} />
        <label className={styles.imageUploadLabel}>
          <input
            type="file"
            accept="image/*"
            onChange={handleImageChange}
            className={styles.imageUploadInput}
          />
          Change Profile Image
        </label>
      </div>
      <form className={styles.formGrid}>
        <div className={styles.formGroup}>
          <label className={styles.label}>First Name</label>
          <input
            type="text"
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Last Name</label>
          <input
            type="text"
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Password</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            className={styles.input}
          />
          <button type="button" className={styles.changePassword}>
            Change Password
          </button>
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Email</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Phone</label>
          <input
            type="tel"
            name="phone"
            value={formData.phone}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Address</label>
          <input
            type="text"
            name="address"
            value={formData.address}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Nation</label>
          <input
            type="text"
            name="nation"
            value={formData.nation}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Gender</label>
          <select
            name="gender"
            value={formData.gender}
            onChange={handleChange}
            className={styles.input}
          >
            <option value="Male">Male</option>
            <option value="Female">Female</option>
          </select>
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Language</label>
          <select
            name="language"
            value={formData.language}
            onChange={handleChange}
            className={styles.input}
          >
            <option value="English">English</option>
            <option value="Spanish">Spanish</option>
          </select>
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Date of Birth</label>
          <div className={styles.dobContainer}>
            <select
              name="dobMonth"
              value={formData.dob.month}
              onChange={handleChange}
              className={styles.input}
            >
              <option value="January">January</option>
              <option value="February">February</option>
              <option value="March">March</option>
              <option value="April">April</option>
              <option value="May">May</option>
              <option value="June">June</option>
              <option value="July">July</option>
              <option value="August">August</option>
              <option value="September">September</option>
              <option value="October">October</option>
              <option value="November">November</option>
              <option value="December">December</option>
            </select>
            <input
              type="text"
              name="dobDay"
              value={formData.dob.day}
              onChange={handleChange}
              className={styles.input}
            />
            <input
              type="text"
              name="dobYear"
              value={formData.dob.year}
              onChange={handleChange}
              className={styles.input}
            />
          </div>
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Twitter</label>
          <input
            type="text"
            name="twitter"
            value={formData.social.twitter}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>LinkedIn</label>
          <input
            type="text"
            name="linkedIn"
            value={formData.social.linkedIn}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Facebook</label>
          <input
            type="text"
            name="facebook"
            value={formData.social.facebook}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Google</label>
          <input
            type="text"
            name="google"
            value={formData.social.google}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Slogan</label>
          <input
            type="text"
            name="slogan"
            value={formData.slogan}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.formGroup}>
          <label className={styles.label}>Payment Method</label>
          <div className={styles.paymentMethods}>
            {formData.paymentMethods.map((method, index) => (
              <div key={index} className={styles.paymentMethod}>
                <span>
                  {method.type} .... {method.last4}
                </span>
                <span>Expires {method.expires}</span>
                <button type="button" className={styles.removePayment}>
                  Remove
                </button>
              </div>
            ))}
          </div>
          <button type="button" className={styles.addPayment}>
            Add Payment Method
          </button>
        </div>
      </form>
    </div>
  );
};

export default Profile;

Profile.defaultProps = {
  ProfileImg: Img1,
};

Profile.propTypes = {
  ProfileImg: PropTypes.string,
};
