import httpClient from "../http-common";

const saveReceipt = (receipt) => {
	return httpClient.post('/api/comprobante/', receipt);
};

const getLapReports = () => {
	return httpClient.get('/api/reporte/reporteVueltas');
}

const getGroupReports = () => {
	return httpClient.get('/api/reporte/reporteGrupo');
}

export default { saveReceipt, getLapReports, getGroupReports };