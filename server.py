import openai as openai
from flask import Flask, jsonify, request, send_file

app = Flask(__name__)

# Replace 'YOUR_API_KEY' with your actual API key
api_key = 'YOUR_API_KEY'

# Initialize the OpenAI API client
openai.api_key = api_key


# @app.route('/api/hello/<name>', methods=['GET'])
# def hello():
#     return jsonify({'message': 'Hello, this is your REST API!'})


@app.route('/api/chatgpt/<question>', methods=['GET'])
def hello(question):
    response = generate_response(question)
    return jsonify({'message': response})


def generate_response(question):
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content": "You are a helpful assistant."},
            {"role": "user", "content": question},
        ]
    )
    # print('response: ', response)
    return response['choices'][0]['message']['content']


if __name__ == '__main__':
    app.run()

if __name__ == '__main__':
    # Example usage
    question = "What's 1+1?"
    answer = generate_response(question)
    print("Answer:", answer)
    # ways to run the flask server
    app.run()
    # app.run(host='0.0.0.0', port=5001)
    # app.run(host='127.0.0.1', port=5000)
    # app.run(debug=True)
