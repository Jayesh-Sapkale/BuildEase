import React, { useState } from 'react';

const CreateProjectForm = ({ onCreate }) => {
  const [builderName, setBuilderName] = useState('');
  const [customBuilderName, setCustomBuilderName] = useState('');
  const [location, setLocation] = useState('');
  const [budget, setBudget] = useState('');
  const [permit, setPermit] = useState('');
  const [startDate, setStartDate] = useState('');
  const [customStartDate, setCustomStartDate] = useState('');
  const [plotRegistered, setPlotRegistered] = useState('');
  const [floorArea, setFloorArea] = useState('');
  const [profession, setProfession] = useState('');
  const [customProfession, setCustomProfession] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const builder = builderName === 'Other' ? customBuilderName : builderName;
    const start = startDate === 'others' ? customStartDate : startDate;
    const prof = profession === 'others' ? customProfession : profession;
    onCreate({ builder, location, budget, permit, start, plotRegistered, floorArea, prof });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="mb-3">
        <label htmlFor="builderName" className="form-label">Builder Name</label>
        <select id="builderName" className="form-select" value={builderName} onChange={(e) => setBuilderName(e.target.value)} required>
          <option value="" disabled>Select Builder</option>
          <option value="Om Prakash (Heights Co.)">Builder 1</option>
          <option value="Shrishti Deshmuk (Unchai Constructions)">Builder 2</option>
          <option value="Akash Shetty (Pune dream Home Construction)">Builder 3</option>
          <option value="Other">Other</option>
        </select>
        {builderName === 'Other' && (
          <input type="text" className="form-control mt-2" placeholder="Enter builder name" value={customBuilderName} onChange={(e) => setCustomBuilderName(e.target.value)} required />
        )}
      </div>

      <div className="mb-3">
        <label htmlFor="location" className="form-label">Location</label>
        <input type="text" id="location" className="form-control" value={location} onChange={(e) => setLocation(e.target.value)} required />
      </div>

      <div className="mb-3">
        <label className="form-label">What is your budget?</label>
        <div className="form-check">
          <input type="radio" id="budget1" name="budget" value="level1" className="form-check-input" onChange={(e) => setBudget(e.target.value)} required />
          <label htmlFor="budget1" className="form-check-label">More than 2cr</label>
        </div>
        <div className="form-check">
          <input type="radio" id="budget2" name="budget" value="level2" className="form-check-input" onChange={(e) => setBudget(e.target.value)} required />
          <label htmlFor="budget2" className="form-check-label">1cr to 2cr</label>
        </div>
        <div className="form-check">
          <input type="radio" id="budget3" name="budget" value="level3" className="form-check-input" onChange={(e) => setBudget(e.target.value)} required />
          <label htmlFor="budget3" className="form-check-label">50L TO 1cr</label>
        </div>
        <div className="form-check">
          <input type="radio" id="budget4" name="budget" value="level4" className="form-check-input" onChange={(e) => setBudget(e.target.value)} required />
          <label htmlFor="budget4" className="form-check-label">20L TO 50L</label>
        </div>
        <div className="form-check">
          <input type="radio" id="budget5" name="budget" value="level5" className="form-check-input" onChange={(e) => setBudget(e.target.value)} required />
          <label htmlFor="budget5" className="form-check-label">Less than 20L</label>
        </div>
      </div>

      <div className="mb-3">
        <label className="form-label">Do you have government permit to construct?</label>
        <div className="form-check">
          <input type="radio" id="permitYes" name="permit" value="YesIhave" className="form-check-input" onChange={(e) => setPermit(e.target.value)} required />
          <label htmlFor="permitYes" className="form-check-label">Yes I have permit</label>
        </div>
        <div className="form-check">
          <input type="radio" id="permitApplied" name="permit" value="Applied" className="form-check-input" onChange={(e) => setPermit(e.target.value)} required />
          <label htmlFor="permitApplied" className="form-check-label">I have applied</label>
        </div>
        <div className="form-check">
          <input type="radio" id="permitYet" name="permit" value="YetToApply" className="form-check-input" onChange={(e) => setPermit(e.target.value)} required />
          <label htmlFor="permitYet" className="form-check-label">Yet To Apply</label>
        </div>
        <div className="form-check">
          <input type="radio" id="permitNo" name="permit" value="No" className="form-check-input" onChange={(e) => setPermit(e.target.value)} required />
          <label htmlFor="permitNo" className="form-check-label">Permit Not Required</label>
        </div>
      </div>

      <div className="mb-3">
        <label htmlFor="startDate" className="form-label">When do you want to start the construction?</label>
        <select id="startDate" className="form-select" value={startDate} onChange={(e) => setStartDate(e.target.value)} required>
          <option value="" disabled>Select</option>
          <option value="immediately">Immediately</option>
          <option value="within 3 months">Within 3 months</option>
          <option value="within 6 months">Within 6 months</option>
          <option value="after 6 months">After 6 months</option>
          <option value="others">Others - specify date</option>
        </select>
        {startDate === 'others' && (
          <input type="date" className="form-control mt-2" value={customStartDate} onChange={(e) => setCustomStartDate(e.target.value)} required />
        )}
      </div>

      <div className="mb-3">
        <label className="form-label">Is the plot registered under your name?</label>
        <div className="form-check">
          <input type="radio" id="plotRegisteredYes" name="plotRegistered" value="Yes" className="form-check-input" onChange={(e) => setPlotRegistered(e.target.value)} required />
          <label htmlFor="plotRegisteredYes" className="form-check-label">Yes</label>
        </div>
        <div className="form-check">
          <input type="radio" id="plotRegisteredNo" name="plotRegistered" value="No" className="form-check-input" onChange={(e) => setPlotRegistered(e.target.value)} required />
          <label htmlFor="plotRegisteredNo" className="form-check-label">No-registered under relative's name</label>
        </div>
        <div className="form-check">
          <input type="radio" id="plotNo" name="plotRegistered" value="NotBuy" className="form-check-input" onChange={(e) => setPlotRegistered(e.target.value)} required />
          <label htmlFor="plotNo" className="form-check-label">No-Yet to buy the plot</label>
        </div>
      </div>

      <div className="mb-3">
        <label htmlFor="floorArea" className="form-label">What is the floor area you are planning? (in sq.ft.)</label>
        <select id="floorArea" className="form-select" value={floorArea} onChange={(e) => setFloorArea(e.target.value)} required>
          <option value="" disabled>Select</option>
          <option value="greater than 2500 sqft">Greater than 2500 sqft</option>
          <option value="1500 to 2500 sqft">1500 to 2500 sqft</option>
          <option value="1000 to 1500 sqft">1000 to 1500 sqft</option>
          <option value="500 to 999 sqft">500 to 999 sqft</option>
          <option value="less than 500 sqft">Less than 500 sqft</option>
        </select>
      </div>

      <div className="mb-3">
        <label htmlFor="profession" className="form-label">What is your profession?</label>
        <select id="profession" className="form-select" value={profession} onChange={(e) => setProfession(e.target.value)} required>
          <option value="" disabled>Select</option>
          <option value="gov employee">Government Employee</option>
          <option value="private sector employee">Private Sector Employee</option>
          <option value="business owner">Business Owner</option>
          <option value="others">Others - specify</option>
        </select>
        {profession === 'others' && (
          <input type="text" className="form-control mt-2" placeholder="Enter your profession" value={customProfession} onChange={(e) => setCustomProfession(e.target.value)} required />
        )}
      </div>

      <button type="submit" className="btn btn-primary">Create Project</button>
    </form>
  );
};

export default CreateProjectForm;
