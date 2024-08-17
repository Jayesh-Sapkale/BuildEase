import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './CoursePayment.css';


const subscriptionPlans = {
  MONTHLY: {
    BASIC: 1000,
    STANDARD: 2000,
    PREMIUM: 3000,
  },
  YEARLY: {
    BASIC: 10000,
    STANDARD: 20000,
    PREMIUM: 30000,
  },
};

function CoursePayment() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [phoneNo, setPhoneNo] = useState('');
  const [role, setRole] = useState('');
  const [subscription, setSubscription] = useState('');
  const [plan, setPlan] = useState('');
  const [amount, setAmount] = useState(0);
  const [loading, setLoading] = useState(false);
  const [razorpayLoaded, setRazorpayLoaded] = useState(false);

  useEffect(() => {
    const loadRazorpay = async () => {
      try {
        const script = document.createElement('script');
        script.src = 'https://checkout.razorpay.com/v1/checkout.js';
        script.async = true;
        document.body.appendChild(script);
        script.onload = () => setRazorpayLoaded(true);
        script.onerror = () => {
          setRazorpayLoaded(false);
          console.error('Failed to load Razorpay SDK');
        };
      } catch (error) {
        console.error('Error loading Razorpay SDK:', error);
      }
    };

    loadRazorpay();
  }, []);

  const handleSubscriptionChange = (e) => {
    const selectedSubscription = e.target.value;
    setSubscription(selectedSubscription);
    updateAmount(selectedSubscription, plan);
  };

  const handlePlanChange = (e) => {
    const selectedPlan = e.target.value;
    setPlan(selectedPlan);
    updateAmount(subscription, selectedPlan);
  };

  const updateAmount = (subscription, plan) => {
    if (subscription && plan) {
      const planAmount = subscriptionPlans[subscription]?.[plan];
      setAmount(planAmount || 0);
    } else {
      setAmount(0);
    }
  };

  const createNewOrder = async () => {
    setLoading(true);
    const url = process.env.REACT_APP_API_URL || 'http://localhost:8081';

    try {
      const response = await axios.post(`${url}/subscription/create-order`, {
        name,
        email,
        phoneNo,
        role,
        subscription,
        plan,
        amount,
      });

      setLoading(false);
      return response.data;
    } catch (error) {
      setLoading(false);
      console.error("Order creation failed:", error.response?.data || error.message);
      throw new Error("Order creation failed");
    }
  };

  const handlePayment = async (e) => {
    e.preventDefault();

    if (!razorpayLoaded) {
      console.error('Razorpay SDK not loaded');
      return;
    }

    try {
      const order = await createNewOrder();

      const options = {
        key: "rzp_test_z3UwSYOIblkTLi", // Replace with your Razorpay API key
        amount: order.amount * 100, // Razorpay expects amount in paise
        currency: 'INR',
        name: 'BuildEase',
        description: 'Course Payment',
        order_id: order.orderId, // Ensure this matches the key in the response
        prefill: {
          name: order.name,
          email: order.email,
          contact: order.phoneNo,
        },
        theme: {
          color: "#3399cc",
        },
      };

      const rzp1 = new window.Razorpay(options);
      rzp1.open();
    } catch (error) {
      console.error("Error during payment initiation", error);
    }
  };

  return (
    <div className="container">
      <h1>Course Payment</h1>
      <form onSubmit={handlePayment}>
        <table className="table">
          <tbody>
            <tr>
              <td>Name:</td>
              <td>
                <input
                  type="text"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  className="form-control"
                  placeholder="Enter your name"
                  required
                />
              </td>
            </tr>
            <tr>
              <td>Email:</td>
              <td>
                <input
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  className="form-control"
                  placeholder="Enter your email"
                  required
                />
              </td>
            </tr>
            <tr>
              <td>Phone Number:</td>
              <td>
                <input
                  type="text"
                  value={phoneNo}
                  onChange={(e) => setPhoneNo(e.target.value)}
                  className="form-control"
                  placeholder="Enter your phone number"
                  required
                />
              </td>
            </tr>
            <tr>
              <td>Select Role:</td>
              <td>
                <select
                  className="form-select"
                  value={role}
                  onChange={(e) => setRole(e.target.value)}
                  required
                >
                  <option value="">Select</option>
                  <option value="BUILDER">Builder</option>
                  <option value="CUSTOMER">Customer</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Select Subscription:</td>
              <td>
                <select
                  className="form-select"
                  value={subscription}
                  onChange={handleSubscriptionChange}
                  required
                >
                  <option value="">Select</option>
                  <option value="MONTHLY">Monthly</option>
                  <option value="YEARLY">Yearly</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Select Plan:</td>
              <td>
                <select
                  className="form-select"
                  value={plan}
                  onChange={handlePlanChange}
                  required
                >
                  <option value="">Select</option>
                  <option value="BASIC">Basic</option>
                  <option value="STANDARD">Standard</option>
                  <option value="PREMIUM">Premium</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Amount:</td>
              <td>
                <input
                  type="number"
                  value={amount}
                  readOnly
                  className="form-control"
                />
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <button type="submit" className="btn btn-primary" disabled={loading}>
                  {loading ? 'Processing...' : 'Proceed to Pay'}
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
      <p className="footer-text">Powered by BuildEase Payment Gateway</p>
    </div>
  );
}

export default CoursePayment;
