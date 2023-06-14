import requests

# Define the base URL of the Flask application
base_url = 'https://model-ml-nen6dlpzra-et.a.run.app'

# Test the home route
response = requests.get(base_url)
print(response.text)

# Test the predict route
data = {
    'Q1': '2',
    'Q2': '3',
    'Q3': '3',
    'Q4': '4',
    'Q5': '2',
    'Q6': '2',
    'Q7': '3',
    'Q8': '3',
    'Q9': '2',
    'Q10': '2',
    'Q11': '4',
    'Q12': '4',
    'Q13': '3',
    'Q14': '3',
    'Q15': '3'
}

response = requests.post(f'{base_url}/', data=data)
print(response.text)