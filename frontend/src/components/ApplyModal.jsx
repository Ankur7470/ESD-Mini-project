import { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import useApplyForPlacement from '../hooks/useApplyForPlacement'; 

const ApplyModal = ({ placement, closeModal, studentDetails }) => {
  const [cvFile, setCvFile] = useState(null);
  const [about, setAbout] = useState('');
  const [isVisible, setIsVisible] = useState(false);

  const { isApplied, applyForPlacement } = useApplyForPlacement();

  useEffect(() => {
    setIsVisible(true);
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    applyForPlacement({placementId: placement.id,studentId: studentDetails.studentId,
      cvFile, about, closeModal,
    });
    setTimeout(() => {
      window.location.reload();
    }, 200);
    
  };

  const handleClose = () => {
    setIsVisible(false);
    setTimeout(() => {
      closeModal();
    }, 300);
  };

  return (
    <div
      className={`fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50 transition-opacity duration-300 ${
        isVisible ? 'opacity-100' : 'opacity-0'
      }`}
    >
      <div
        className={`bg-white p-6 rounded-xl shadow-lg w-full max-w-md mx-4 transform transition-all duration-300 ${
          isVisible ? 'scale-100' : 'scale-90'
        }`}
      >
        <h2 className="text-2xl font-bold text-gray-800 mb-4">
          Apply for <span className="text-indigo-600">{placement.organisation}</span> -{' '}
          <span className="text-indigo-600">{placement.profile}</span>
        </h2>
        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label htmlFor="name" className="block text-sm font-medium text-gray-700">
              Name
            </label>
            <input
              type="text"
              id="name"
              name="name"
              defaultValue={`${studentDetails.firstName} ${studentDetails.lastName}`}
              readOnly
              className="mt-1 block w-full text-sm border border-gray-300 rounded-lg px-3 py-2 bg-gray-50 text-gray-700 focus:ring-indigo-500 focus:border-indigo-500"
            />
          </div>
          <div>
            <label htmlFor="email" className="block text-sm font-medium text-gray-700">
              Email
            </label>
            <input
              type="text"
              id="email"
              name="email"
              defaultValue={studentDetails.email}
              readOnly
              className="mt-1 block w-full text-sm border border-gray-300 rounded-lg px-3 py-2 bg-gray-50 text-gray-700 focus:ring-indigo-500 focus:border-indigo-500"
            />
          </div>
          <div>
            <label htmlFor="cvFile" className="block text-sm font-medium text-gray-700">
              Upload CV
            </label>
            <input
              type="file"
              id="cvFile"
              name="cvFile"
              accept=".pdf,.doc,.docx"
              onChange={(e) => setCvFile(e.target.files[0])}
              required
              className="mt-1 block w-full text-sm border border-gray-300 rounded-lg px-3 py-2 bg-gray-50 text-gray-700 focus:ring-indigo-500 focus:border-indigo-500"
            />
          </div>
          <div>
            <label htmlFor="about" className="block text-sm font-medium text-gray-700">
              About You
            </label>
            <textarea
              id="about"
              name="about"
              value={about}
              onChange={(e) => setAbout(e.target.value)}
              rows="4"
              className="mt-1 block w-full text-sm border border-gray-300 rounded-lg px-3 py-2 bg-gray-50 text-gray-700 focus:ring-indigo-500 focus:border-indigo-500"
              placeholder="Tell us about yourself"
              required
            />
          </div>
          {isApplied ? (
            <div className="text-sm text-gray-500 mt-2 text-center">
              You have already applied to this company.
            </div>
          ) : (
            <div className="flex justify-end space-x-4">
              <button
                type="button"
                onClick={handleClose}
                className="px-4 py-2 bg-gray-300 hover:bg-gray-400 text-gray-700 rounded-lg shadow focus:outline-none focus:ring-2 focus:ring-gray-400"
              >
                Close
              </button>
              <button
                type="submit"
                className="px-4 py-2 bg-indigo-600 hover:bg-indigo-700 text-white rounded-lg shadow focus:outline-none focus:ring-2 focus:ring-indigo-600"
              >
                Apply
              </button>
            </div>
          )}
        </form>
      </div>
    </div>
  );
};

ApplyModal.propTypes = {
  placement: PropTypes.object.isRequired,
  closeModal: PropTypes.func,
  studentDetails: PropTypes.object.isRequired,
};

export default ApplyModal;


