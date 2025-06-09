import httpClient from "../http-common";

const saveReservation = (reservation) => {
	return httpClient.post('/api/reserva/', reservation);
};

const getReservationsForCalendar = () => {
    return httpClient.get("/api/rack/");
};

const getReservationById = (id) => {
	return httpClient.get(`/api/reserva/${id}`);
}

export default { saveReservation, getReservationsForCalendar, getReservationById };