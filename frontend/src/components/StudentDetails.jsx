import PropTypes from 'prop-types';

const StudentDetails = ({ studentDetails }) => {
  if (!studentDetails) {
    return <p className="text-gray-500">No student details available.</p>;
  }

  const API_BASE_URL = 'http://localhost:8080/'

  return (
    <div className="space-y-4 text-gray-700">
      <div>
        <img
          src={`${API_BASE_URL}${studentDetails.photographPath}`}
          className="w-[200px] h-[180px] rounded-lg border border-gray-300"
        />
      </div>

      <p>
        <strong className="text-gray-600">Name:</strong> {studentDetails.firstName} {studentDetails.lastName}
      </p>
      <p>
        <strong className="text-gray-600">Email:</strong> {studentDetails.email}
      </p>
      <p>
        <strong className="text-gray-600">CGPA:</strong> {studentDetails.cgpa}
      </p>
      <p>
        <strong className="text-gray-600">Domain:</strong> {studentDetails.domainName}
      </p>
      <p>
        <strong className="text-gray-600">Specialisation:</strong> {studentDetails.specialisationName}
      </p>
    </div>
  );
};

StudentDetails.propTypes = {
  studentDetails: PropTypes.object.isRequired
};


export default StudentDetails;
