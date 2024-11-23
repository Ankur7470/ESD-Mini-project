import PropTypes from 'prop-types';
import PlacementCard from "./PlacementCard";

const PlacementList = ({ placements }) => {
  return (
    <div className="overflow-y-auto h-[calc(100vh-64px)]">
      {placements.length > 0 ? (
        <ul className="space-y-6">
          {placements.map((placement) => (
            <PlacementCard key={placement.id} placement={placement} />
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
        title: PropTypes.string.isRequired,
        company: PropTypes.string.isRequired,
        location: PropTypes.string,
        salary: PropTypes.string,
        eligibility: PropTypes.string.isRequired,
      })
    ).isRequired,
  };

export default PlacementList;
