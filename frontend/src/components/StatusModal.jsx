import PropTypes from "prop-types";
import { useState, useEffect } from "react";
import useApplicationStatus from "../hooks/useApplicationStatus";

const StatusModal = ({ placementId, studentId, closeModal }) => {
  const { status, loading, error } = useApplicationStatus(studentId, placementId);
  const [isVisible, setIsVisible] = useState(false); 
  const [isMounted, setIsMounted] = useState(false);

  useEffect(() => {
    setIsMounted(true); 
    const timer = setTimeout(() => {
      setIsVisible(true);
    }, 20); 

    return () => clearTimeout(timer); 
  }, []);

  const handleClose = () => {
    setIsVisible(false); 
    setTimeout(() => {
      setIsMounted(false); 
      closeModal(); 
    }, 300); 
  };

  if (!isMounted) return null;

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
        <h2 className="text-3xl font-bold text-gray-800 mb-4 text-center">
          Application Status
        </h2>
        <p className="text-lg text-gray-700 mb-2">
          <strong>Placement:</strong> {placementId}
        </p>
        <p className="text-lg text-gray-700 mb-6">
          <strong>Student ID:</strong> {studentId}
        </p>

        {loading && <div>Loading...</div>}
        {error && <div>Error: {error.message}</div>}

        {!loading && !error && (
          <div className="mt-4 space-y-4">
            <p className="text-lg text-gray-600">
              <strong>CV Application:</strong> {status?.cvApplication || "No application found"}
            </p>
            <p className="text-lg text-gray-600">
              <strong>About:</strong> {status?.about || "No information provided"}
            </p>
            <p className="text-lg text-gray-600">
              <strong>Acceptance:</strong> {status?.acceptance ? "Accepted" : "Pending/Rejected"}
            </p>
            <p className="text-lg text-gray-600">
              <strong>Comments:</strong> {status?.comments || "No comments yet"}
            </p>
          </div>
        )}

        <div className="flex justify-center space-x-4 mt-8">
          <button
            type="button"
            onClick={handleClose}
            className="px-6 py-3 bg-indigo-600 hover:bg-indigo-700 text-white rounded-xl shadow-lg transition duration-200 ease-in-out transform hover:scale-105 focus:outline-none focus:ring-2 focus:ring-indigo-500"
          >
            Close
          </button>
        </div>
      </div>
    </div>
  );
};

StatusModal.propTypes = {
  placementId: PropTypes.number.isRequired,
  studentId: PropTypes.number.isRequired,
  closeModal: PropTypes.func.isRequired,
};

export default StatusModal;