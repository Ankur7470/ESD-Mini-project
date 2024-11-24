import PropTypes from 'prop-types';

const StudentDetails = ({ studentDetails }) => {
  if (!studentDetails) {
    return <p className="text-gray-500">No student details available.</p>;
  }

  return (
    <div className="space-y-4 text-gray-700">
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
    // studentDetails: PropTypes.shape({
    //   firstName: PropTypes.string.isRequired,
    //   lastName: PropTypes.string.isRequired,
    //   email: PropTypes.string.isRequired,
    //   cgpa: PropTypes.number.isRequired,
    //   domainName: PropTypes.string.isRequired,
    //   specialisationName : PropTypes.string.isRequired
    // }).isRequired,
  };
  

export default StudentDetails;
