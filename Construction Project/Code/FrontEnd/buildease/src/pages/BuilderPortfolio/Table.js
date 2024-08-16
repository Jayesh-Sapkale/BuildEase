import React from 'react';

const Table = ({ data = [], onStatusChange, tab }) => {
    const isPendingRequests = tab === "Pending Requests";

    return (
        <section className="builder-portfolio-section">
            <h2>{tab}</h2>
            <div className="builder-portfolio-table-container">
                <table className="builder-portfolio-table">
                    <thead>
                        <tr>
                            <th>Project Details Id</th>
                            <th>Builder Name</th>
                            <th>Customer Name</th>
                            <th>Construction Type</th>
                            <th>City</th>
                            <th>Project Name</th>
                           
                            <th>Request Status</th>
                            {isPendingRequests && <th>Actions</th>}
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((work) => (
                            <tr key={work.projectId}>
                                <td>{work.projectId}</td>
                                <td>{work.builderName}</td>
                                <td>{work.customerName}</td>
                                <td>{work.constructionType}</td>
                                <td>{work.city}</td>
                                <td>{work.projectName}</td>
                               
                                <td>{work.requestStatus}</td>
                                {isPendingRequests && (
                                    <td className="action-buttons">
                                        {work.projectStatus !== "Accepted" && work.projectStatus !== "Declined" && (
                                            <>
                                                <button
                                                    className="accept"
                                                    onClick={() => onStatusChange(work.projectId, true)}
                                                >
                                                    Accept
                                                </button>
                                                <button
                                                    className="decline"
                                                    onClick={() => onStatusChange(work.projectId, false)}
                                                >
                                                    Decline
                                                </button>
                                            </>
                                        )}
                                    </td>
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
