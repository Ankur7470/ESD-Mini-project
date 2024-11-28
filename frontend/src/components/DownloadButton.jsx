import PropTypes from 'prop-types';
import { FaFileDownload } from "react-icons/fa";

const DownloadButton = ({ status }) => {
    const fileUrl = `http://localhost:8080/${status.cvApplication}`;

    return (
        <a href={fileUrl} target="_blank" download={status.cvApplication}>
            <button className="px-4 text-red-700 pt-1 border-none rounded-md cursor-pointer transition duration-200 ease-in-out">
                <FaFileDownload className="text-[23px]"/>
            </button>
        </a>
    );
};

DownloadButton.propTypes = {
    status: PropTypes.shape({
        cvApplication: PropTypes.string.isRequired,
    }).isRequired,
};
export default DownloadButton;
