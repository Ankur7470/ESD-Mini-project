import PropTypes from 'prop-types';
import { useState } from "react";
import ApplyModal from "./ApplyModal";
import StatusModal from "./StatusModal";

const PlacementCard = ({ placement, isApplied, studentDetails }) => {
  const [isModalOpen, setModalOpen] = useState(false);
  const [showApplyModal, setShowApplyModal] = useState(false);
  const [showStatusModal, setShowStatusModal] = useState(false);

  const closeModal = () => {
    setModalOpen(false);
    setShowApplyModal(false);
    setShowStatusModal(false);
  };

  return (
    <div className="p-6 bg-white shadow-lg rounded-lg border border-gray-200 hover:shadow-xl transition duration-300 flex">
      <div className="w-3/5 pr-6">
        <p>
          <strong className="text-indigo-600">Organisation:</strong> {placement.organisation}
        </p>
        <p>
          <strong className="text-indigo-600">Profile:</strong> {placement.profile}
        </p>
        <p>
          <strong className="text-indigo-600">Description:</strong> {placement.description || "N/A"}
        </p>
        <p>
          <strong className="text-indigo-600">Intake:</strong> {placement.intake}
        </p>
        <p>
          <strong className="text-indigo-600">Minimum Grade:</strong> {placement.minimumGrade}
        </p>
        {isApplied ? (
          <button
            onClick={() => {
              setShowStatusModal(true);
              setModalOpen(true);
            }}
            className="mt-4 px-4 py-2 bg-indigo-600 text-white rounded-lg shadow-md hover:bg-indigo-700 hover:shadow-lg hover:scale-105 focus:outline-none focus:ring-2 focus:ring-indigo-400 transition-all duration-300 ease-in-out active:scale-95"
          >
            Check Status
          </button>
        ) : (
          <button
            onClick={() => {
              setShowApplyModal(true);
              setModalOpen(true);
            }}
            className="mt-4 px-4 py-2 bg-indigo-600 text-white rounded-lg shadow-md hover:bg-indigo-700 hover:shadow-lg hover:scale-105 focus:outline-none focus:ring-2 focus:ring-indigo-400 transition-all duration-300 ease-in-out active:scale-95"
          >
            Apply
          </button>
        )}
      </div>
      <div className="w-2/5 bg-gradient-to-tr from-indigo-300 via-blue-200 to-green-200 rounded-lg opacity-70"></div>

      {showApplyModal && isModalOpen && (
        <ApplyModal
          placement={placement}
          studentDetails={studentDetails}
          closeModal={closeModal}
        />
      )}

      {showStatusModal && isModalOpen && (
        <StatusModal
          placementId={placement.id}
          studentId={studentDetails.studentId}
          closeModal={closeModal}
        />
      )}
    </div>
  );
};

PlacementCard.propTypes = {
  placement: PropTypes.shape({
    id: PropTypes.number.isRequired,
    organisation: PropTypes.string.isRequired,
    profile: PropTypes.string.isRequired,
    description: PropTypes.string,
    intake: PropTypes.number.isRequired,
    minimumGrade: PropTypes.number.isRequired,
  }).isRequired,
  isApplied: PropTypes.bool.isRequired,
  studentDetails: PropTypes.object.isRequired,
};

export default PlacementCard;
