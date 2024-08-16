import React from 'react';

const Table = ({ data = [], onStatusChange, tab }) => {
    const isPendingRequests = tab === "Pending Requests";
    const isBuilderReviews = tab === "Reviews"; // Condition for Builder Reviews

    return (
        <section className="builder-portfolio-section">
            <h2>{tab}</h2>
            <div className="builder-portfolio-table-container">
                <table className="builder-portfolio-table">
                    <thead>
                        <tr>
                            {isBuilderReviews ? (
                                <>
                                    <th>Review ID</th>
                                    <th>Customer Name</th>
                                    <th>Builder Name</th>
                                    <th>Rating</th>
                                    <th>Review</th>
                                    <th>Review Date</th>
                                </>
                            ) : (
                                <>
                                    <th>Project Details Id</th>
                                    <th>Builder Name</th>
                                    <th>Customer Name</th>
                                    <th>Construction Type</th>
                                    <th>City</th>
                                    <th>Project Name</th>
                                    <th>Request Status</th>
                                    {isPendingRequests && <th>Actions</th>}
                                </>
                            )}
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((item) => (
                            <tr key={item.projectId || item.builderReviewId}>
                                {isBuilderReviews ? (
                                    <>
                                        <td>{item.builderReviewId}</td>
                                        <td>{item.customerName}</td>
                                        <td>{item.builderName}</td>
                                        <td>{item.rating}</td>
                                        <td>{item.review}</td>
                                        <td>{item.reviewDate}</td>
                                    </>
                                ) : (
                                    <>
                                        <td>{item.projectId}</td>
                                        <td>{item.builderName}</td>
                                        <td>{item.customerName}</td>
                                        <td>{item.constructionType}</td>
                                        <td>{item.city}</td>
                                        <td>{item.projectName}</td>
                                        <td>{item.requestStatus}</td>
                                        {isPendingRequests && (
                                            <td className="action-buttons">
                                                {item.projectStatus !== "Accepted" && item.projectStatus !== "Declined" && (
                                                    <>
                                                        <button
                                                            className="accept"
                                                            onClick={() => onStatusChange(item.projectId, true)}
                                                        >
                                                            Accept
                                                        </button>
                                                        <button
                                                            className="decline"
                                                            onClick={() => onStatusChange(item.projectId, false)}
                                                        >
                                                            Decline
                                                        </button>
                                                    </>
                                                )}
                                            </td>
                                        )}
                                    </>
                                )}
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </section>
    );
};

export default Table;
