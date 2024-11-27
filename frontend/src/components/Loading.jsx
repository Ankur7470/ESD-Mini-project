import PropTypes from 'prop-types';

// const Loading = ({ message }) => {
//     return (
//       <div className="flex items-center justify-center min-h-screen bg-gray-50">
//         <div className="text-center">
//           <p className="text-gray-600 text-xl font-medium mb-4">
//             Loading {message}...
//           </p>
//           <div className="animate-spin rounded-full h-12 w-12 border-t-4 border-blue-600 border-opacity-50"></div>
//         </div>
//       </div>
//     );
//   };

const Loading = ({ message }) => {
  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-50">
      <div className="flex flex-col items-center">
        <div className="animate-spin rounded-full h-12 w-12 border-t-4 border-blue-600 border-opacity-50 mb-4"></div>
        <p className="text-gray-600 text-xl font-medium">
          Loading {message}...
        </p>
      </div>
    </div>
  );
};

  Loading.propTypes = {
    message: PropTypes.string.isRequired
  };

  export default Loading;