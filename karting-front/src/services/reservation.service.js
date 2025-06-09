import httpClient from "../http-common";

const saveReservation = (reservation) => {
	return httpClient.post('/api/reserva/', reservation);
};

const getReservationsForCalendar = () => {
    return httpClient.get("/api/rack/");
};

export default { saveReservation, getReservationsForCalendar };