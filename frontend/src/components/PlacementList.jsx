import PropTypes from 'prop-types';
import PlacementCard from "./PlacementCard";

const PlacementList = ({ placements, appliedPlacements, studentDetails }) => {
  return (
    <div className="overflow-y-auto h-[calc(100vh-64px)]">
      {placements.length > 0 ? (
        <ul className="space-y-6">
          {placements.map((placement) => (
            <li key={placement.id}>
              <PlacementCard placement={placement} isApplied={appliedPlacements.some((applied) => applied.id === placement.id)} studentDetails={studentDetails} />
            </li>
          ))}
        </ul>
      ) : (
        <p className="text-gray-500">No eligible placements available.</p>
      )}
    </div>
  );
};

PlacementList.propTypes = {
  placements: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      organisation: PropTypes.string.isRequired,
      profile: PropTypes.string.isRequired,
      description: PropTypes.string,
      intake: PropTypes.number.isRequired,
      minimumGrade: PropTypes.number.isRequired,
    })
  ).isRequired,
  appliedPlacements: PropTypes.array.isRequired,
  studentDetails: PropTypes.object.isRequired,
};

export default PlacementList;


