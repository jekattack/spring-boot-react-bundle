import {waitFor} from "@testing-library/react";

test('form is sent', async () => {
//     jest.spyOn(axios, 'get').mockImplementation(() => {
//         return Promise.resolve({
//             status: 200,
//             json: () => Promise.resolve([
//                 {
//                     id: "018054646",
//                     status: "IN_PROGRESS",
//                     task: "Schuhe kaufen",
//                     description: "Bei Kaufland"
//                 },
//                 {
//                     id: "018054646",
//                     status: "IN_PROGRESS",
//                     task: "Schuhe kaufen",
//                     description: "Bei Kaufland"
//                 }
//             ])
//         } as Response);
//     });
//
//     render(<Form onTaskCreation={() => {
//     }}/>);
//
    await waitFor(() => {
//         expect(screen.getByTestId('name-0').textContent).toEqual('Thomas');
    });
});