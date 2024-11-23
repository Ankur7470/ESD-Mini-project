import PropTypes from 'prop-types';

const PlacementCard = ({placement}) => {
  return (
    <li className="p-6 bg-white shadow-lg rounded-lg border border-gray-200 hover:shadow-xl transition duration-300">
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
    </li>
  );
};

PlacementCard.propTypes = {
    placement: PropTypes.shape({
      organisation: PropTypes.string.isRequired,
      profile: PropTypes.string.isRequired,
      description: PropTypes.string,
      intake: PropTypes.number.isRequired,
      minimumGrade: PropTypes.number.isRequired,
    }).isRequired,
  };
  
export default PlacementCard;
