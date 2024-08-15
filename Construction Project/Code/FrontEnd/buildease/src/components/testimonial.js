import React from "react";

import PropTypes from "prop-types";

import "./testimonial.css";

import img1 from "../assets/testimonials/jas.png";
import img2 from "../assets/testimonials/mim.png";
import img3 from "../assets/testimonials/ani.png";
import img4 from "../assets/testimonials/val.png";

const Testimonial = (props) => {
  return (
    <div className="thq-section-padding">
      <div className="testimonial-max-width thq-section-max-width">
        <div className="testimonial-container">
          <h2 className="thq-heading-2">{props.heading1}</h2>
          <span className="testimonial-text01 thq-body-small">
            {props.content1}
          </span>
        </div>
        <div className="thq-grid-2">
          <div className="thq-animated-card-bg-2">
            <div className="thq-animated-card-bg-1">
              <div data-animated="true" className="thq-card testimonial-card">
                <div className="testimonial-container02">
                  <img
                    alt={props.author1Alt}
                    src={props.author1Src}
                    className="testimonial-image"
                  />
                  <div className="testimonial-container03">
                    <strong className="thq-body-large">
                      {props.author1Name}
                    </strong>
                    <span className="thq-body-small">
                      {props.author1Position}
                    </span>
                  </div>
                </div>
                <span className="testimonial-text04 thq-body-small">
                  {props.review1}
                </span>
              </div>
            </div>
          </div>
          <div className="thq-animated-card-bg-2">
            <div className="thq-animated-card-bg-1">
              <div data-animated="true" className="thq-card testimonial-card1">
                <div className="testimonial-container04">
                  <img
                    alt={props.author2Alt}
                    src={props.author2Src}
                    className="testimonial-image1"
                  />
                  <div className="testimonial-container05">
                    <strong className="thq-body-large">
                      {props.author2Name}
                    </strong>
                    <span className="thq-body-small">
                      {props.author2Position}
                    </span>
                  </div>
                </div>
                <span className="testimonial-text07 thq-body-small">
                  {props.review2}
                </span>
              </div>
            </div>
          </div>
          <div className="thq-animated-card-bg-2">
            <div className="thq-animated-card-bg-1">
              <div data-animated="true" className="thq-card testimonial-card2">
                <div className="testimonial-container06">
                  <img
                    alt={props.author3Alt}
                    src={props.author3Src}
                    className="testimonial-image2"
                  />
                  <div className="testimonial-container07">
                    <strong className="thq-body-large">
                      {props.author3Name}
                    </strong>
                    <span className="thq-body-small">
                      {props.author3Position}
                    </span>
                  </div>
                </div>
                <span className="testimonial-text10 thq-body-small">
                  {props.review3}
                </span>
              </div>
            </div>
          </div>
          <div className="thq-animated-card-bg-2">
            <div className="thq-animated-card-bg-1">
              <div data-animated="true" className="thq-card testimonial-card3">
                <div className="testimonial-container08">
                  <img
                    alt={props.author4Alt}
                    src={props.author4Src}
                    className="testimonial-image3"
                  />
                  <div className="testimonial-container09">
                    <strong className="thq-body-large">
                      {props.author4Name}
                    </strong>
                    <span className="thq-body-small">
                      {props.author4Position}
                    </span>
                  </div>
                </div>
                <span className="testimonial-text13 thq-body-small">
                  {props.review4}
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

Testimonial.defaultProps = {
  heading1: "Testimonials",

  content1: "Read what our clients have to say about us.",

  author1Src: img1,
  author2Src: img2,
  author3Src: img3,
  author4Src: img4,

  author1Name: "Jayesh Sapkale",
  author2Name: "Mimansha Shekhawat",
  author3Name: "Aniket Ghodake",
  author4Name: "Vallabh Jadhav",

  author1Position: "CEO, CDAC Inc.",
  author2Position: "Marketing Manager, CDAC Corp.",
  author3Position: "Project Manager, CDAC Co.",
  author4Position: "Designer, CDAC Designs",

  author1Alt: "Jayesh Sapkale Image",
  author2Alt: "Mimansha Shekhawat Image",
  author3Alt: "Aniket Ghodake Image",
  author4Alt: "Vallabh Jadhav Image",

  review1:
    "BUILDEASE exceeded our expectations with their attention to detail and commitment to quality. Our dream home is now a reality, thanks to their expert team.",
  review2:
    "From start to finish, the professionalism and craftsmanship of BUILDEASE were top-notch. They transformed our vision into a stunning, functional space.",
  review3:
    "We were impressed by the seamless process and the quality of work delivered by BUILDEASE. Their dedication to customer satisfaction is truly remarkable.",
  review4:
    "BUILDEASE made our renovation project stress-free and successful. Their innovative approach and reliable service are unmatched in the industry.",
};

Testimonial.propTypes = {
  heading1: PropTypes.string,

  content1: PropTypes.string,

  author1Position: PropTypes.string,
  author2Position: PropTypes.string,
  author4Position: PropTypes.string,
  author3Position: PropTypes.string,

  author1Alt: PropTypes.string,
  author2Alt: PropTypes.string,
  author3Alt: PropTypes.string,
  author4Alt: PropTypes.string,

  author1Src: PropTypes.string,
  author2Src: PropTypes.string,
  author3Src: PropTypes.string,
  author4Src: PropTypes.string,

  author1Name: PropTypes.string,
  author3Name: PropTypes.string,
  author2Name: PropTypes.string,
  author4Name: PropTypes.string,

  review1: PropTypes.string,
  review2: PropTypes.string,
  review3: PropTypes.string,
  review4: PropTypes.string,
};

export default Testimonial;
