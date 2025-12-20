import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: [
    { duration: '30s', target: 10 },
    { duration: '1m', target: 20 },
    { duration: '30s', target: 0 },
  ],
};

export default function () {

  const payload = JSON.stringify({
    tenderType: 'CREDIT_CARD',
    amount: 120.50,
    transactionId: 'TXN-' + Math.floor(Math.random() * 100000)
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const res = http.post(
    'http://localhost:8082/api/pos/tenders',
    payload,
    params
  );

  check(res, {
    'status is success (2xx)': (r) => r.status >= 200 && r.status < 300,
  });

  sleep(1);
}
