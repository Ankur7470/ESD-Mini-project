import PropTypes from 'prop-types';

const Error = ({ error, onRetry }) => {
    return (
      <div className="flex flex-col items-center justify-center min-h-screen bg-gray-50">
        <p className="text-red-500 text-lg font-semibold mb-6">{error}</p>
        <button
          onClick={onRetry}
          className="bg-blue-500 hover:bg-blue-600 text-white font-medium py-2 px-6 rounded-lg transition duration-300"
        >
          Retry
        </button>
      </div>
    );
  };
  
  Error.propTypes = {
    error: PropTypes.string.isRequired,  
    onRetry: PropTypes.func.isRequired,  
  };

  export default Error;