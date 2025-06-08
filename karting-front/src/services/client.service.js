import httpClient from "../http-common";

const registerClient = (client) => {
	return httpClient.post('/api/cliente/', client);
}

const getAll = () => {
	return httpClient.get('/api/cliente/');
}

const updateClient = (client) => {
	return httpClient.put('/api/cliente/', client);
}

const deleteClient = (clientId) => {
	return httpClient.delete(`/api/cliente/${clientId}`);
}

export default { getAll, registerClient, updateClient, deleteClient };
