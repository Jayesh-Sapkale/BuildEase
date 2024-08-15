import React from "react";

const BuildersTable = () => {
  const handleEdit = (id) => {
    console.log(`Edit button clicked for item with ID: ${id}`);
  };

  const handleDelete = (id) => {
    console.log(`Delete button clicked for item with ID: ${id}`);
    if (window.confirm("Are you sure you want to delete this item?")) {
      console.log(`Item with ID: ${id} deleted.`);
    }
  };

  const handleView = (id) => {
    console.log(`View button clicked for item with ID: ${id}`);
  };

  return (
    <div className="table-container">
      <section>
        <h2>List of Builders</h2>
        <div className="table-wrapper">
          <table>
            <thead>
              <tr>
                <th>Builder ID</th>
                <th>Name</th>
                <th>Sites</th>
                <th>Status</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                  <a href="builder1.html">1</a>
                </td>
                <td>Builder Inc.</td>
                <td>Site A</td>
                <td>Active</td>
                <td>
                  <div className="action-buttons">
                    <button
                      className="button edit-btn"
                      onClick={() => handleEdit(1)}
                    >
                      Edit
                    </button>
                    <button
                      className="button delete-btn"
                      onClick={() => handleDelete(1)}
                    >
                      Delete
                    </button>
                    <button
                      className="button view-btn"
                      onClick={() => handleView(1)}
                    >
                      View
                    </button>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </section>
    </div>
  );
};

export default BuildersTable;
