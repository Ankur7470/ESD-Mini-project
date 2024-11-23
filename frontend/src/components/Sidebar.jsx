import PropTypes from 'prop-types';
import StudentDetails from "./StudentDetails";

const Sidebar = ({ studentDetails, onLogout }) => {
  return (
    <div className="w-1/4 bg-white shadow-lg p-6 flex flex-col justify-between fixed top-0 bottom-0 left-0 rounded-r-3xl">
      <div>
        <h2 className="text-2xl font-semibold text-indigo-600 mt-8 mb-6">Student Details</h2>
        <StudentDetails studentDetails={studentDetails} />
      </div>
      <button
        onClick={onLogout}
        className="w-full mt-6 mb-4 bg-red-500 hover:bg-red-600 text-white font-semibold py-2 px-4 rounded-lg transition duration-300"
      >
        Logout
      </button>
    </div>
  );
};

Sidebar.propTypes = {
    studentDetails: PropTypes.shape({
      studentId: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
      email: PropTypes.string.isRequired,
      course: PropTypes.string.isRequired,
      branch: PropTypes.string.isRequired,
      year: PropTypes.string.isRequired,
    }).isRequired,
    onLogout: PropTypes.func.isRequired,
  };

export default Sidebar;
