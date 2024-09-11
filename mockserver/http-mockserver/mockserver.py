import json
import random
import uuid

from flask import Flask, jsonify, make_response

response_error = {"id": uuid.uuid4(), "status": "ERROR"}

api = Flask(__name__)


def create_route_function(response):
    def route_function():
        if 'possible_responses' not in response or not response['possible_responses']:
            response_code = 200
            response_json = jsonify(response)
        else:
            response['id'] = str(uuid.uuid4())
            response_code = random.choice(response['possible_responses'])
            response_copy = response.copy()
            del response_copy['possible_responses']
            response_json = jsonify(response_copy)

        if response_code != 200:
            return make_response(jsonify(response_error), response_code)
        else:
            return response_json

    return route_function

with open('metadata.json', encoding='iso-8859-1') as f:
    metadata = json.load(f)

for endpoint in metadata:
    path = endpoint['path']
    method = endpoint['method']
    response = endpoint['response']
    route_function = create_route_function(response)

    api.add_url_rule(path, f'{method}_{path}', route_function, methods=[method])

if __name__ == '__main__':
    api_port = 7077
    api.run(port=api_port)
